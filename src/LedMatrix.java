package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;


public interface LedMatrix {

    public int width();
    public int height();
    default boolean isDirty() { return true; }
    default void setDirty(boolean b) { };
    
    public void drawPixel(int x, int y, int c);
    
    default void drawBitmap(long bitmap, int x, int y, int fg, int bg, int w, int h) {
        int wt = width();
        int ht = height();
        int i0 = (x < 0) ? -x : 0;  // clip left
        int j0 = (y < 0) ? -y : 0;  // clip bottom
        if (x+w >= wt) w = wt-x;       // clip right
        if (y+h >= ht) h = ht-y;       // clip top
        for (int j = j0; j < h; j++) {
            long mask = 0x0100000000000000L << j;
            if (i0 > 0) mask = mask >>> (8 * i0);
            for (int i = i0; i < w; i++) {
                drawPixel(x+i, y+j, (bitmap & mask) != 0 ? fg : bg);
                mask = mask >>> 8;
            }
        }
    }
    default void drawBitmap(long bitmap, int x, int y, int fg, int bg) {
        drawBitmap(bitmap, x, y, fg, bg, 8, 8);
    }
    
    default void drawBitmap(long bitmap[], int x, int y, int fg, int bg, int w, int h) {
        int wt = width();
        int ht = height();
        int i0 = (x < 0) ? -x : 0;
        int j0 = (y < 0) ? -y : 0;
        if (x+w >= wt) w = wt-x;
        if (y+h >= ht) h = ht-y;
        for (int i = i0; i < w; i++) {
            long mask = 1 << j0;
            long b = (i < bitmap.length) ? bitmap[i] : 0;
            for (int j = j0; j < h; j++) {
                drawPixel(x+i, y+j, (b & mask) != 0 ? fg : bg);
                mask = mask << 1;
            }
        }
    }
    default void drawBitmap(long bitmap[], int x, int y, int fg, int bg) {
        drawBitmap(bitmap, x, y, fg, bg, bitmap.length, 64);
    }
    
    default void drawChar(BitmapFont font, char c, int x, int y, int fg, int bg) {
        if (c < 0 || c >= font.cmap.length) c = 0;
        drawBitmap(font.cmap[c], x, y, fg, bg, font.cwidth, font.cheight);
    }
    default void drawChar(char c, int x, int y, int fg, int bg) {
        drawChar(font5x7, c, x, y, fg, bg);
    }
    
    default boolean drawString(BitmapFont font, String s, int x, int y, int fg, int bg) {
        int wt = width();
        if (x >= wt) return false;
        int cw = font.cwidth + 1;
        int l = s.length();
        for (int i = 0; i < l; i++) {
            if (x >= wt) break;
            if (x+cw >= 0) {
                drawChar(font, s.charAt(i), x, y, fg, bg);
            }
            x += cw;
        }
        return (x >= 0);
    }
    default boolean drawString(String s, int x, int y, int fg, int bg) {
        return drawString(font5x7, s, x, y, fg, bg);
    }
    
    default boolean drawPropString(BitmapFont font, String s, int x, int y, int fg, int bg) {
        int wt = width();
        if (x >= wt) return false;
        int l = s.length();
        for (int i = 0; i < l; i++) {
            if (x >= wt) break;
            char c = s.charAt(i);
            if (c < 0 || c >= font.cmap.length) c = 0;
            long cmap = font.cmap[c];
            int cw = font.cwidth+1;
            if (cmap != 0) {
                while ((cmap & 0xff00000000000000L) == 0) cmap = cmap << 8;
                for (cw = 1; (cw < 8) && ((cmap & (0xff00000000000000L >>> (cw*8))) != 0); cw++) {}
                cw++;
            }
            if (x+cw >= 0) {
                drawBitmap(cmap, x, y, fg, bg, cw, font.cheight);
            }
            x += cw;
        }
        return (x >= 0);
    }
    
    default void drawRect(int x, int y, int w, int h, int color) {
        for (int i = 0; i < w; i++) {
            drawPixel(x+i, y, color);
            drawPixel(x+i, y+h-1, color);
        }
        for (int j = 0; j < h; j++) {
            drawPixel(x, y+j, color);
            drawPixel(x+w-1, y+j, color);
        }
    }
    
    default void fillRect(int x, int y, int w, int h, int color) {
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                drawPixel(x+i, y+j, color);
            }
        }
    }

    public class BitmapFont {
        public int cwidth;
        public int cheight;
        public long cmap[] = null;
        
        public BitmapFont(int w, int h, long[] m) {
            cwidth = w;
            cheight = h;
            cmap = m;
        }
    }
    
    public BitmapFont font5x7 = new BitmapFont(5, 7,new long[]{
        // ▯ █ ▯ ▯ ♠ ♥ ♦ ♣ ← ↑ → ↓
        0x7f4141417f000000L, 0x7f7f7f7f7f000000L, 0x7f4141417f000000L, 0x7f4141417f000000L, 
        0x1c3d7f3d1c000000L, 0x1c3e1f3e1c000000L, 0x0c1e3f1e0c000000L, 0x1c755f751c000000L, 
        0x081c2a0808000000L, 0x08103f1008000000L, 0x08082a1c08000000L, 0x04023f0204000000L, 
        0x7f4141417f000000L, 0x7f4141417f000000L, 0x7f4141417f000000L, 0x7f4141417f000000L, 

        0x7f4141417f000000L, 0x7f4141417f000000L, 0x7f4141417f000000L, 0x7f4141417f000000L, 
        0x7f4141417f000000L, 0x7f4141417f000000L, 0x7f4141417f000000L, 0x7f4141417f000000L, 
        0x7f4141417f000000L, 0x7f4141417f000000L, 0x7f4141417f000000L, 0x7f4141417f000000L, 
        0x7f4141417f000000L, 0x7f4141417f000000L, 0x7f4141417f000000L, 0x7f4141417f000000L, 

        //  <sp> ! " # $ % & ' ( ) * + , - . /
        0x0000000000000000L, 0x00007d0000000000L, 0x0070007000000000L, 0x147f147f14000000L,
        0x122a7f2a24000000L, 0x6264081323000000L, 0x3649552205000000L, 0x0000600000000000L,
        0x001c224100000000L, 0x0041221c00000000L, 0x2a1c3e1c2a000000L, 0x08083e0808000000L, 
        0x0005060000000000L, 0x0808080808000000L, 0x0003030000000000L, 0x0204081020000000L,
        
        // 0 1 2 3 4 5 6 7 8 9 : ; < = > ?
        0x3e4549513e000000L, 0x00217f0100000000L, 0x2345494931000000L, 0x2241494936000000L,
        0x0c14247f04000000L, 0x725151514e000000L, 0x1e29494906000000L, 0x4047485060000000L,
        0x3649494936000000L, 0x3049494a3c000000L, 0x0036360000000000L, 0x0035360000000000L,
        0x0814224100000000L, 0x1414141414000000L, 0x0041221408000000L, 0x2040454830000000L,
        
        // @ A B C D E F G H I J K L M N O
        0x3e415d4d39000000L, 0x1f2444241f000000L, 0x417f494936000000L, 0x3e41414122000000L,
        0x417f41413e000000L, 0x7f49494941000000L, 0x7f48484840000000L, 0x3e4141492f000000L,
        0x7f0808087f000000L, 0x00417f4100000000L, 0x0201417e40000000L, 0x7f08142241000000L,
        0x7f01010101000000L, 0x7f2018207f000000L, 0x7f1008047f000000L, 0x3e4141413e000000L,
        
        // P Q R S T U V W X Y Z [ \ ] ^ _ 
        0x7f48484830000000L, 0x3e4145423d000000L, 0x7f484c4a31000000L, 0x3249494926000000L,
        0x40407f4040000000L, 0x7e0101017e000000L, 0x7c0201027c000000L, 0x7e010e017e000000L,
        0x6314081463000000L, 0x7008070870000000L, 0x4345495161000000L, 0x007f414100000000L,
        0x2010080402000000L, 0x0041417f00000000L, 0x1020402010000000L, 0x0101010101000000L,

        // ` a b c d e f g h i j k l m n o
        0x0040201000000000L, 0x021515150f000000L, 0x7f0911110e000000L, 0x0e1111110a000000L,
        0x0e1111097f000000L, 0x0e1515150c000000L, 0x083f484020000000L, 0x081515151e000000L,
        0x7f0810100f000000L, 0x00115f0100000000L, 0x0201115e00000000L, 0x7f040a1100000000L,
        0x00417f0100000000L, 0x1f100f100f000000L, 0x1f0810100f000000L, 0x0e1111110e000000L,
        
        // p q r s t u v w x y z { | } ~ DEL
        0x1f14141408000000L, 0x0814140c1f000000L, 0x1f08101008000000L, 0x0915151512000000L,
        0x107e110102000000L, 0x1e0101021f000000L, 0x1c0201021c000000L, 0x1e0106011e000000L,
        0x110a040a11000000L, 0x180505051e000000L, 0x1113151911000000L, 0x0008364100000000L,
        0x00007f0000000000L, 0x0041360800000000L, 0x1020100810000000L, 0x1c2444241c000000L,
        });
        
    public BitmapFont font3x5 = new BitmapFont(3, 6, new long[]{
        0x3e223e0000000000L, 0x3e223e0000000000L, 0x3e223e0000000000L, 0x3e223e0000000000L, 
        0x3e223e0000000000L, 0x3e223e0000000000L, 0x3e223e0000000000L, 0x3e223e0000000000L, 
        0x3e223e0000000000L, 0x3e223e0000000000L, 0x3e223e0000000000L, 0x3e223e0000000000L, 
        0x3e223e0000000000L, 0x3e223e0000000000L, 0x3e223e0000000000L, 0x3e223e0000000000L, 
        
        0x3e223e0000000000L, 0x3e223e0000000000L, 0x3e223e0000000000L, 0x3e223e0000000000L, 
        0x3e223e0000000000L, 0x3e223e0000000000L, 0x3e223e0000000000L, 0x3e223e0000000000L, 
        0x3e223e0000000000L, 0x3e223e0000000000L, 0x3e223e0000000000L, 0x3e223e0000000000L, 
        0x3e223e0000000000L, 0x3e223e0000000000L, 0x3e223e0000000000L, 0x3e223e0000000000L, 

        //  <sp> ! " # $ % & ' ( ) * + , - . /
        0x0000000000000000L, 0x003a000000000000L, 0x3000300000000000L, 0x3e143e0000000000L,
        0x143e280000000000L, 0x2408120000000000L, 0x3c3a0e0000000000L, 0x0030000000000000L,
        0x001c220000000000L, 0x221c000000000000L, 0x2810280000000000L, 0x081c080000000000L,
        0x0204000000000000L, 0x0808080000000000L, 0x0002000000000000L, 0x0608300000000000L,
        
        // 0 1 2 3 4 5 6 7 8 9 : ; < = > ?
        0x1e223c0000000000L, 0x103e000000000000L, 0x262a120000000000L, 0x222a140000000000L,
        0x38083e0000000000L, 0x3a2a240000000000L, 0x1e2a2e0000000000L, 0x2628300000000000L,
        0x3e2a3e0000000000L, 0x3a2a3c0000000000L, 0x0014000000000000L, 0x0214000000000000L,
        0x0814220000000000L, 0x1414140000000000L, 0x2214080000000000L, 0x202a300000000000L,
        
        // @ A B C D E F G H I J K L M N O
        0x1c2a1a0000000000L, 0x1e281e0000000000L, 0x3e2a140000000000L, 0x1c22220000000000L, 
        0x3e221c0000000000L, 0x3e2a2a0000000000L, 0x3e28280000000000L, 0x1c2a2e0000000000L, 
        0x3e083e0000000000L, 0x223e220000000000L, 0x04023c0000000000L, 0x3e08360000000000L, 
        0x3e02020000000000L, 0x3e183e0000000000L, 0x3e1c3e0000000000L, 0x1c221c0000000000L, 
        
        // P Q R S T U V W X Y Z [ \ ] ^ _ 
        0x3e28100000000000L, 0x1c261e0000000000L, 0x3e2c1a0000000000L, 0x122a240000000000L,
        0x203e200000000000L, 0x3c023e0000000000L, 0x3806380000000000L, 0x3e0c3e0000000000L,
        0x3608360000000000L, 0x300e300000000000L, 0x262a320000000000L, 0x3e22220000000000L,
        0x1008040000000000L, 0x22223e0000000000L, 0x1020100000000000L, 0x0202020000000000L,

        // ` a b c d e f g h i j k l m n o
        0x2010000000000000L, 0x161a0e0000000000L, 0x3e120c0000000000L, 0x0c12120000000000L,
        0x0c123e0000000000L, 0x0c161a0000000000L, 0x081e280000000000L, 0x0c151e0000000000L,
        0x3e100e0000000000L, 0x002e000000000000L, 0x02012e0000000000L, 0x3e0c120000000000L,
        0x223e020000000000L, 0x1e1c1e0000000000L, 0x1e100e0000000000L, 0x0c120c0000000000L,

        // p q r s t u v w x y z { | } ~ DEL
        0x1f120c0000000000L, 0x0c121f0000000000L, 0x0e10100000000000L, 0x0a1e140000000000L,
        0x103e120000000000L, 0x1c021e0000000000L, 0x1c061c0000000000L, 0x1e0e1e0000000000L,
        0x120c120000000000L, 0x18051e0000000000L, 0x161e1a0000000000L, 0x0836220000000000L,
        0x0036000000000000L, 0x2236080000000000L, 0x1030200000000000L, 0x1828180000000000L,
        });

}
