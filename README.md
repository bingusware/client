# bingusware

[![Lisence](https://img.shields.io/badge/lisence-MIT-brightgreen.svg)](https://github.com/bigratenthusiast/chungusware/blob/main/LICENSE)

The bingusware client (minecraft 1.5.2 experience enhancer)

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
- Uncheck all the mods
- Select your original minecraft 1.5.2 jar
- Select where the output will go
- Hit the plus sign and add your *zip file*
- Hit patch


## Contributing
Pull requests are welcome! Please don't have original minecraft source files in your PR. Instead copy the files you've changed into `./bingusware_src/` (legal stuff 🙄)

## License
[MIT](https://choosealicense.com/licenses/mit/)
