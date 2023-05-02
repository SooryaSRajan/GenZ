file=$1

path=$(pwd)
file="$path/$file"

# if file not found show error and exit
if [ ! -f "$file" ]
then
    echo "Error: File not found"
    exit 1
fi

if [[ $file != *.genz ]]
then
    echo "Warning: Please compile .genz file"
    exit 1
fi

if ! [ -x "$(command -v java)" ]; then
  echo 'Error: java is not installed.' >&2
  exit 1
fi

java -jar /usr/local/genz/GenZLang-1.4.1-jar-with-dependencies.jar "$file"


