# bingusware

[![Lisence](https://img.shields.io/badge/lisence-MIT-brightgreen.svg)](https://github.com/bigratenthusiast/chungusware/blob/main/LICENSE)

The bingusware client (minecraft 1.5.2 experience enhancer)

![bingus](https://user-images.githubusercontent.com/77901819/130656268-294ca15e-ed71-4ca3-9131-23e250e4b866.gif)


## Setup
- Run the `decompile` script (either `decompile.sh` or `decompile.bat` depending on your operating system)
- Copy the contents of `./bingusware_src/` into `/src` and replace all files that have conflicts

## Testing
- Run `recompile`
- Run `startclient`
- If you run into issues with `startclient` remove the arg `-Xincgc` from `CmdStartClt` in `/client/conf/mcp.cfg`

## Building
- Run `recompile` and `reobfuscate`
- Head into `/reobf/minecraft` and put everything in it into the root of a *zip* file
- Now you can patch the jar

## Patching
- Download [mcpatcher 3.0.4](https://bitbucket.org/prupe/mcpatcher/downloads/mcpatcher-3.0.4_02.jar)
- Select your original minecraft 1.5.2 jar
- Select where the output will go
- Uncheck all the mods
- Hit the plus sign and add your *zip* file
- Hit patch


## Contributing
Pull requests are welcome! Please don't have original minecraft source files in your PR. Instead copy the files you've changed into `./bingusware_src/` (legal stuff 🙄)

## License
[MIT](https://choosealicense.com/licenses/mit/)
