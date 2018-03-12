# Selenium Page Object Pattern example with Java - Expedia Travel website.

## Description:
Page Object Pattern with Page Factory, implementation base on the __https://www.expedia.com/__ webpage.

### Tests were implemented and run on:

* System: Linux Ubuntu 16.04 LTS
* Browsers: Firefox Quantum 58.0.2, Chrome 65.0.3325.146 (both 64-bit)
* Selenium WebDriver: 3.9.0
* Java 1.8.0

### To Run Tests - Linux Ubuntu:

1.Install JDK 1.8
2.Install Apache Maven
3.Install IDE of your choice (Eclipse, IntelliJ IDEA)
4.Download drivers, unpack, make executable and copy to /usr/local/bin:

__geckodriver__: https://github.com/mozilla/geckodriver/releases
__chromedriver__: https://sites.google.com/a/chromium.org/chromedriver/

(example below shows how add to path __geckodriver__)

```
tar -xvzf geckodriver-v0.11.1-linux64.tar.gz
rm geckodriver-v0.11.1-linux64.tar.gz
chmod +x geckodriver
cp geckodriver /usr/local/bin/
```
4.Add drivers to the PATH
5.Clone/Download project: https://github.com/MaBlaGit/ExpediaAutomatedWithJava.git
6.Open project and run in selected IDE
