# PrimeNumberLibrary

## Prerequisites

This program uses the Boost libraries multiprecision integers and therefore it requires you to download boost using either your package manager 
or source code.

If you want to use your package manager to install try one of these commands based on your distribution.

### Arch-linux
```
sudo pacman -S boost 
```
NOTE: If you are having trouble installing boost, you might want to check if the maintainers have changed the name of the package.
You can do this by typing
```
sudo pacman -Ss boost
```
This will list all the packages related to boost.

### Ubuntu
```
sudo apt-get install boost
```

NOTE: If you are having trouble installing boost, you might want to check if the maintainers have changed the name of the package.
You can do this by typing 
```
apt-cache search boost
```
This will list all the packages related to boost.

## Compilation

This makefile will compile and create an executable file called fermatprime in the current directory by default. If you want to make this into 
a systemwide command, type `sudo make install` if you have root privileges, if not contact your system administrator. Once done, the executable will be copied to `/usr/local/bin` directory. 
Using this command requires an argument. This argument can be arbitrarily long integer.

To execute the command type with local executable type:

```
./fermatprime <number>
```

where `<number>` is the number that you want to check.

If `sudo make install` has been used, it would run if you type:

```
fermatprime <number>
```
---
## Maths in this program

If you are interested in maths behind the functions, please take a look at MathsBehind file. This file was created using Jupyter-notebook, and can be run online within this interface. Just click on it and you are good to go.

---

Keep in mind that this program is based on Fermat's Little Theorem and is not very accurate. I am still working on ways that can improve the accuracy of this function.
The prime.h library also has some (extra) functions that you might like to try and are very usefull. I haven't used most of them because they 
were reducing the speed at which it checks the number but they can still be modified to get better results.

Note: The makefile uses GNU make format wildcards, therefore in some BSD systems it would potentially not compile properly unless you 
specifically use GMake. I am trying to figure out a way to make it more cross platform so that this works in most `*nix` systems.
