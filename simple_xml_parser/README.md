# App ReadXmlDomParser
Parse a specific XML file and print some info to console.
## Appropriate XML file example
```xml
<?xml version="1.0" encoding="UTF-8"?>
<workflow-app name="testApp">
    <global>
        <configuration>
            <property id="1">
                <name>test_property1</name>
                <value>Test value of property #1</value>
            </property>
            <property id="2">
                <name>test_property2</name>
                <value>Test value of property #2</value>
            </property>
            <property id="3">
                <name>test_property3</name>
                <value>Test value of property #3</value>
            </property>
        </configuration>
    </global>
</workflow-app>
```
## Compile an app
In Linux:
```bash
javac ReadXmlDomParser.java
```
Example:
```bash
[username@hostname ~]$ javac ReadXmlDomParser.java
[username@hostname ~]$ ls -l
-rw-rw-r-- 1 username username 2457 Oct 22 13:33 ReadXmlDomParser.class
-rw-rw-r-- 1 username username 2732 Oct 22 13:30 ReadXmlDomParser.java
-rw-rw-r-- 1 username username  643 Oct 22 13:13 wf.xml
```

## Run an app
Usage:
`java ReadXmlDomParser <path/to/file.xml>`

In Linux:
```bash
[username@hostname ~]$ java ReadXmlDomParser "wf.xml"
```

Example:
```bash
[username@hostname ~]$ ls -l
-rw-rw-r-- 1 username username 2457 Oct 22 13:33 ReadXmlDomParser.class
-rw-rw-r-- 1 username username 2732 Oct 22 13:30 ReadXmlDomParser.java
-rw-rw-r-- 1 username username  643 Oct 22 13:13 wf.xml
[username@hostname ~]$
[username@hostname ~]$ java ReadXmlDomParser "wf.xml"
Root XML element: workflow-app

Current element:   property
Element ID:        1
Property name:     test_property1
Property value:    Test value of property #1

Current element:   property
Element ID:        2
Property name:     test_property2
Property value:    Test value of property #2

Current element:   property
Element ID:        3
Property name:     test_property3
Property value:    Test value of property #3
```
