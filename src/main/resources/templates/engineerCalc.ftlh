<#-- @ftlvariable name="message" type="java.lang.String" -->
<#-- @ftlvariable name="expressionEng" type="java.lang.String" -->

<#import "/spring.ftl" as spring>
<#import "commons.ftlh" as c>
<@c.page>
    <div class="calculator form-box">
        <div class="header">Enter expression</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="calcEng"/>
                <table>
                    <tr>
                        <td colspan="3"><input autofocus type="text" id="expression" name="expressionEng"
                                               value="${expressionEng!}"/></td>
                        <td><input type="submit" value="="></td>
                        <#--                        <td><button name="button" value="c" onclick="clear()"/> </td>-->
                    </tr>
                    <tr>
                        <td><button name="button" value="(" onclick="dis('(')">(</button></td>
                        <td><button name="button" value=")" onclick="dis(')')">)</button></td>
                        <td><button name="button" value="sin()" onclick="dis(' sin(')">sin()</button></td>
                        <td><button name="button" value="cos()" onclick="dis(' cos(')">cos()</button></td>
                    </tr>
                    <tr>
                        <td><button name="button" value="sqrt()" onclick="dis(' sqrt(')">sqrt()</button></td>
                        <td><button name="button" value="x^2" onclick="dis('^2 ')">x<sup>2</sup></button></td>
                        <td><button name="button" value="tan()" onclick="dis(' tan(')">tan()</button></td>
                        <td><button name="button" value="atan()" onclick="dis(' atan(')">atan()</button></td>
                    </tr>
                    <tr>
                        <td><button name="button" value="abs()" onclick="dis(' abs(')">abs()</button></td>
                        <td><button name="button" value="x^y" onclick="dis('^')">x<sup>y</sup></button></td>
                        <td><button name="button" value="x!" onclick="dis('!')">x!</button></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="digit"><button name="digit" value="1" onclick="dis('1')">1</button></td>
                        <td class="digit"><button name="digit" value="2" onclick="dis('2')">2</button></td>
                        <td class="digit"><button name="digit" value="3" onclick="dis('3')">3</button></td>
                        <td><button name="button" value="/" onclick="dis('/')">/</button></td>
                    </tr>
                    <tr>
                        <td class="digit"><button name="digit" value="4" onclick="dis('4')">4</button></td>
                        <td class="digit"><button name="digit" value="5" onclick="dis('5')">5</button></td>
                        <td class="digit"><button name="digit" value="6" onclick="dis('6')">6</button></td>
                        <td><button name="button" value="-" onclick="dis('-')">-</button></td>
                    </tr>
                    <tr>
                        <td class="digit"><button name="digit" value="7" onclick="dis('7')">7</button></td>
                        <td class="digit"><button name="digit" value="8" onclick="dis('8')">8</button></td>
                        <td class="digit"><button name="digit" value="9" onclick="dis('9')">9</button></td>
                        <td><button name="button" value="+" onclick="dis('+')">+</button></td>
                    </tr>
                    <tr>
                        <td><button name="button" value="." onclick="dis('.')">.</button></td>
                        <td class="digit"><button name="digit" value="0" onclick="dis('0')">0</button></td>
                        <td></td>
                        <td><button name="button" value="*" onclick="dis('*')">*</button></td>
                    </tr>
                </table>
                <div class="message">
                    <#if message??>
                        ${message}
                    </#if>
                </div>
            </form>
        </div>
    </div>
</@c.page>