# bingusware

[![Lisence](https://img.shields.io/badge/lisence-MIT-brightgreen.svg)](https://github.com/bigratenthusiast/chungusware/blob/main/LICENSE)

The bingusware client (minecraft 1.5.2 experience enhancer)

![bingus](https://user-images.githubusercontent.com/77901819/130656268-294ca15e-ed71-4ca3-9131-23e250e4b866.gif)


## Setup
- Run `decompile.sh` or `decompile.bat`
- Copy the contents of `./bingusware_src/` into src and replace all files that have conflicts

## Building
- Run `recompile.sh` or `recompile.bat`
- Run `reobfuscate.sh` or `reobfuscate.bat`
- Go to `./reobf/minecraft` and put everything in a *zip file*
- Now you can patch the jar

## Patching
- Download [mcpatcher 3.0.4](https://bitbucket.org/prupe/mcpatcher/downloads/mcpatcher-3.0.4_02.jar)
- Select your original minecraft 1.5.2 jar
- Select where the output will go
- Uncheck all the mods
- Hit the plus sign and add your *zip file*
- Hit patch


## Contributing
Pull requests are welcome! Please don't have original minecraft source files in your PR. Instead copy the files you've changed into `./bingusware_src/` (legal stuff 🙄)

## License
[MIT](https://choosealicense.com/licenses/mit/)
