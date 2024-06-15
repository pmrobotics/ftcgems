# Minimal makefile for Sphinx documentation
#

# You can set these variables from the command line, and also
# from the environment for the first two.
SPHINXOPTS    ?=
SPHINXBUILD   ?= sphinx-build
SOURCEDIR     = source
BUILDDIR      = build

AUTOBUILD = sphinx-autobuild
AUTOBUILDOPTS = --ignore "*.swp"
HTMLBUILDDIR = build/html
USBDRIVEDIR = build/usbdrive

# Put it first so that "make" without argument is like "make help".
help:
	@$(SPHINXBUILD) -M help "$(SOURCEDIR)" "$(BUILDDIR)" $(SPHINXOPTS) $(O)

.PHONY: help Makefile

autobuild:
	@$(AUTOBUILD) $(AUTOBUILDOPTS) $(SOURCEDIR) $(HTMLBUILDDIR)

usbclean:
	rm -rf $(USBDRIVEDIR)

usbdrive: usbclean clean html
	mkdir -p $(USBDRIVEDIR)
	cp -av $(HTMLBUILDDIR) $(USBDRIVEDIR)/slides
	cp -av ../src $(USBDRIVEDIR)/src

requirements: 
	pip install -r source/requirements.txt

# Catch-all target: route all unknown targets to Sphinx using the new
# "make mode" option.  $(O) is meant as a shortcut for $(SPHINXOPTS).
%: Makefile
	@$(SPHINXBUILD) -M $@ "$(SOURCEDIR)" "$(BUILDDIR)" $(SPHINXOPTS) $(O)
