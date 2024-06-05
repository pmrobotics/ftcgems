package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchDevice;
import com.qualcomm.robotcore.hardware.configuration.annotations.I2cDeviceType;
import com.qualcomm.robotcore.hardware.configuration.annotations.DeviceProperties;
import com.qualcomm.robotcore.hardware.I2cAddr;

@I2cDeviceType
@DeviceProperties(name = "Adafruit LED Matrix", description = "Adafruit LED Matrix", xmlTag = "AFLEDMATRIX")
public class AdafruitLedMatrix extends I2cDeviceSynchDevice<I2cDeviceSynch> implements LedMatrix {
    
    public static enum Flavor { SMALL8X8, SMALL16X8, BICOLOR, MINI8X8 };

    public final int LED_TRANS = -1;
    public final int LED_OFF = 0x000000;
    public final int LED_ON = 0x00ff00;
    public final int LED_RED = 0xff0000;
    public final int LED_GREEN = 0x00ff00;
    public final int LED_BLUE = 0x0000ff;
    public final int LED_YELLOW = 0xffff00;
    public final int LED_AMBER = LED_YELLOW;
    
    public final int BLINK_OFF = 0;
    public final int BLINK_STEADY = 1;
    public final int BLINK_2HZ = 3;
    public final int BLINK_1HZ = 5;
    public final int BLINK_05HZ = 7;

    public Flavor flavor = Flavor.SMALL8X8;
    public int displayFrame[] = null;
    public int fwidth = 8;
    public int fheight = 8;
    public int rotation = 0;
    public boolean autoclear = false;
    public boolean dirty = true;
    
    public Manufacturer getManufacturer() {
        return Manufacturer.Adafruit;
    }

    public synchronized boolean doInitialize() {
        return true;
    }

    public String getDeviceName() {
        return "Adafruit LED Matrix";
    }

    public AdafruitLedMatrix(I2cDeviceSynch deviceClient) {
        super(deviceClient, true);
        this.deviceClient.setI2cAddress(I2cAddr.create7bit(0x70));
        super.registerArmingStateCallback(false);
        this.deviceClient.engage();
        byte[] cmd = { 0x21 };
        this.deviceClient.write(cmd);
        setFlavor(Flavor.SMALL8X8);
        displayFrame = new int[]{0xc000,0x8060,0x0040,0,0,0,0,0};
        show();
        setBrightness(0x40);
        setBlink(BLINK_STEADY);
    }
    
    public void setFlavor(Flavor f) {
        flavor = f;
        switch (flavor) {
            case SMALL16X8:
                fwidth = 16; fheight = 8;
                break;
            default:
                fwidth = 8; fheight = 8;
                break;
        }
    }
    
    public void setRotation(int r) {
        rotation = r % 4;
    }
    
    public void setAutoClear(boolean b) {
        autoclear = b;
    }
    
    public void setDirty(boolean b) { dirty = b; }
    public boolean isDirty() { return dirty; }

    public int width() { return (rotation % 2 == 0) ? fwidth : fheight; }
    public int height() { return (rotation % 2 == 0) ? fheight : fwidth; }

    @Override
    public void drawPixel(int x, int y, int color) {
        if (color < 0) return;
        if (flavor == Flavor.BICOLOR) { drawPixelBicolor(x, y, color); return; }
        int wt = width();
        int ht = height();
        if (x < 0 || x >= wt || y < 0 || y >= ht) return;
        int t = x;
        switch (rotation % 4) {
            case 0: x = (wt-1) - x; y = (ht-1) - y; break;
            case 1: x = (ht-1) - y; y = t; break;
            case 2: break;
            case 3: x = y; y = (wt-1) - t; break;
        }
        x = (x+7) % 8;
        int mask = 1 << x;
        switch (color) {
            case LED_OFF:
                displayFrame[y] = displayFrame[y] & ~(mask);
                break;
            default:
                displayFrame[y] = displayFrame[y] | mask;
                break;
        }
    }
    
    public void drawPixelBicolor(int x, int y, int color) {
        if (color < 0) return;
        if (x < 0 || x >=8 || y < 0 || y >= 8) return;
        color = ((color & 0x00ff00) != 0 ? 1 : 0)
                | ((color & 0xff0000) != 0 ? 2 : 0)
                | (color & 0x000003);
        int t = x;
        switch (rotation % 4) {
            case 0: x = 7 - x; y = 7 - y; break;
            case 1: x = 7 - y; y = t; break;
            case 2: break;
            case 3: x = y; y = 7 - t; break;
        }
        int mask = 1 << x;
        switch (color) {
            case 0: // off
                displayFrame[y] = displayFrame[y] & ~(mask * 0x101);
                break;
            case 1: // green
                displayFrame[y] = (displayFrame[y] & ~(mask<<8)) | mask;
                break;
            case 2: // red
                displayFrame[y] = (displayFrame[y] & ~(mask)) | (mask << 8);
                break;
            case 3: // yellow, amber
                displayFrame[y] = displayFrame[y] | mask * 0x101;
                break;
        }
        setDirty(true);
    }

    public void setBrightness(int b) {
        byte[] cmd = new byte[1];
        cmd[0] = (byte)(0xe0 | Range.clip(b/16, 0, 15));
        this.deviceClient.write(cmd);
    }
    
    public void setBlink(int b) {
        byte[] cmd = new byte[1];
        cmd[0] = (byte)(0x80 | b);
        this.deviceClient.write(cmd);
    }

    public void clear() {
        for (int i = 0; i < 8; i++) displayFrame[i] = 0;
        setDirty(true);
    } 
    
    public void show() {
        byte[] buffer = new byte[17];
        buffer[0] = 0;
        for (int i = 0; i < 8; i++) {
            long v = displayFrame[7-i];
            buffer[1+2*i] = (byte)(v & 0xff);
            buffer[2+2*i] = (byte)(v >> 8);
        }
        this.deviceClient.write(buffer);
        setDirty(false);
        if (autoclear) { clear(); }
    }

}
