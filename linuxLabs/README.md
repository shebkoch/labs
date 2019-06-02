# how to use
## Lab3
```shell
g++ 1.cpp
./a.out
killall -SIGUSR1 a.out
```
## Lab4
```shell
g++ 1.cpp
./a.out ~/Documents/test
killall -SIGUSR1 a.out
killall -SIGUSR2 a.out
killall a.out
```
## Lab5
```shell
sudo cp a.service /etc/systemd/system
systemctl enable a.service
systemctl start a
systemctl status a
systemctl kill -s SIGUSR1 a
systemctl kill -s SIGUSR2 a
```

## Lab6
```shell
fakeroot dpkg-deb --build a
sudo apt install ./a.deb
```
