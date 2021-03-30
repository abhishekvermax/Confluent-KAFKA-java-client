# Manually Install Java 8

Prerequisites, may need to accept licence
A text editor, whether it's vi, vim, emacs, nano etc.


### Step 1: Download the latest JDK
It is recommended that you install only the latest JDK.

```bash
wget https://download.oracle.com/otn/java/jdk/8u281-b09/89d678f2be164786b292527658ca1605/jdk-8u281-linux-x64.tar.gz
```

### Step 2: Extract JDK to Java's default location after doing SCP to EC2 machine
Create a jvm folder in /usr/lib/ which is the default location for Java.

```
sudo mkdir /usr/lib/jvm
```

Go to the created /usr/lib/jvm folder.

```bash
cd /usr/lib/jvm
```
Extract the downloaded JDK.

```bash
sudo tar -xvzf ~/Downloads/jdk-8u281-linux-x64.tar.gz
```
### Step 3: Set environment variables
Edit the environment file.

```bash
sudo nano /etc/environment
```

Update the existing PATH variable by adding the below bin folders, separated with a colon :.

```bash
/usr/lib/jvm/jdk1.8.0_281/bin:/usr/lib/jvm/jdk1.8.0_281/db/bin:/usr/lib/jvm/jdk1.8.0_281/jre/bin
```

```bash
J2SDKDIR="/usr/lib/jvm/jdk1.8.0_281"
J2REDIR="/usr/lib/jvm/jdk1.8.0_281/jre"
JAVA_HOME="/usr/lib/jvm/jdk1.8.0_281"
DERBY_HOME="/usr/lib/jvm/jdk1.8.0_281/db"
```

The environment file should now be similar to this text:

```bash
PATH="/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/usr/lib/jvm/jdk1.8.0_281/bin:/usr/lib/jvm/jdk1.8.0_281/db/bin:/usr/lib/jvm/jdk1.8.0_281/jre/bin"
J2SDKDIR="/usr/lib/jvm/jdk1.8.0_281"
J2REDIR="/usr/lib/jvm/jdk1.8.0_281/jre*
JAVA_HOME="/usr/lib/jvm/jdk1.8.0_281"
DERBY_HOME="/usr/lib/jvm/jdk1.8.0_281/db"
Save changes and close the file.
```

### Step 4: Inform Ubuntu about the installed location
Use update-alternatives to inform Ubuntu about the installed java paths.

```bash
sudo update-alternatives --install "/usr/bin/java" "java" "/usr/lib/jvm/jdk1.8.0_281/bin/java" 0
sudo update-alternatives --install "/usr/bin/javac" "javac" "/usr/lib/jvm/jdk1.8.0_281/bin/javac" 0
sudo update-alternatives --set java /usr/lib/jvm/jdk1.8.0_281/bin/java
sudo update-alternatives --set javac /usr/lib/jvm/jdk1.8.0_281/bin/javac
```

### Step 5: Setup verification
Give the location of java and javac as you provided.

```bash
update-alternatives --list java
update-alternatives --list javac
```
open a new terminal.

### Step 6: Verify the Java version

```bash
java -version
```

The output should resemble the following:

```bash
java version "1.8.0_281"
Java(TM) SE Runtime Environment (build 1.8.0_281-b09)
Java HotSpot(TM) 64-Bit Server VM (build 25.281-b09, mixed mode)
```

You should be able to see your installed java version which means you have successfully installed the Oracle JDK.
