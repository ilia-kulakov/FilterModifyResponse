Filter Modify Response: AEM 6.1
========

Create a configurable Sling filter that looks through HTML and JSON responses that contain Geometrixx website pages
and replaces the company name. The filter must replace “Geometrixx” word in the responses depending on the run mode

This a content package project generated using the multimodule-content-package-archetype.

Run mode        What to replace     Replacement

“algebra”       Geometrixx          Algebraixx

“trigo”         Geometrixx          Trigonometrixx

<default (no    Geometrixx          Geometrio, LLC
specific
runmode)>

Building
--------

This project uses Maven for building. Common commands:

From the root directory, run ``mvn -PautoInstallPackage clean install`` to build the bundle and content package and install to a CQ instance.

From the bundle directory, run ``mvn -PautoInstallBundle clean install`` to build *just* the bundle and install to a CQ instance.

Using with VLT
--------------

To use vlt with this project, first build and install the package to your local CQ instance as described above. Then cd to `content/src/main/content/jcr_root` and run

    vlt --credentials admin:admin checkout -f ../META-INF/vault/filter.xml --force http://localhost:4502/crx

Once the working copy is created, you can use the normal ``vlt up`` and ``vlt ci`` commands.

Specifying CRX Host/Port
------------------------

The CRX host and port can be specified on the command line with:
mvn -Dcrx.host=otherhost -Dcrx.port=5502 <goals>


