#!/bin/bash

DESTINATION_FOLDER="/usr/local/genz"
if [ ! -d "$DESTINATION_FOLDER" ]; then
  mkdir "$DESTINATION_FOLDER"
fi

shopt -s extglob
mv !(install-mac.sh) "$DESTINATION_FOLDER"

if ! grep -q "alias genz='bash /usr/local/genz/genz.sh'" ~/.zshrc; then
    echo "alias genz='bash /usr/local/genz/genz.sh'" >> ~/.zshrc
fi

echo "Installation complete. Please restart your terminal and source your bashrc file."
source ~/.zshrc