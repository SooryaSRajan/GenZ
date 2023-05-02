#!/bin/bash

DESTINATION_FOLDER="/usr/local/genz"
if [ ! -d "$DESTINATION_FOLDER" ]; then
  mkdir "$DESTINATION_FOLDER"
fi

shopt -s extglob
mv !(install-linux.sh) "$DESTINATION_FOLDER"

if ! grep -q "alias genz='bash /usr/local/genz/genz.sh'" ~/.bashrc; then
    echo "alias genz='bash /usr/local/genz/genz.sh'" >> ~/.bashrc
fi

echo "Installation complete. Please restart your terminal and source your bashrc file."
source ~/.bashrc