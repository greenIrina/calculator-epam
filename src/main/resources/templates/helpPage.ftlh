<#import "/spring.ftl" as spring>
<#import "commons.ftlh" as c>
<@c.page>
    <h1>Manual</h1>
    List of available constants (in order to use them you need to type their identifications):
    <div class="datatable">
        <table>
            <thead class="caption">
            <tr>
                <td>Constant</td>
                <td>Identification</td>
                <td>Value</td>
            </tr>

            </thead>
            <tbody>
            <tr>
                <td>Exponent</td>
                <td>e</td>
                <td>2.718281828459045</td>
            </tr>
            <tr>
                <td>Pi number</td>
                <td>pi</td>
                <td>3.141592653589793</td>
            </tr>
            </tbody>
        </table>
    </div>

    Syntax of operations and functions:
    <div class="datatable" style="width: 40%">
        <table>
            <thead class="caption">
            <tr>
                <td>Function</td>
                <td>Syntax</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>log<sub>x</sub>y</td>
                <td>x // y</td>
            </tr>
            <tr>
                <td>x<sup>y</sup></td>
                <td>x^y</td>
            </tr>
            <tr>
                <td>x<sup>2</sup></td>
                <td>x^2</td>
            </tr>
            <tr>
                <td>&radic;x</td>
                <td>sqrt(x)</td>
            </tr>
            <tr>
                <td>x!</td>
                <td>factorial(x)</td>
            </tr>
            </tbody>
        </table>
    </div>
    <b>CAUTION:</b> power function is Left Distributive!!! 2<sup>2<sup>3</sup></sup> = 64 .


</@c.page>