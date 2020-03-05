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
                        <td colspan="4"><input autofocus type="text" id="expression" name="expressionEng"
                                               value="${expressionEng!}"/></td>
                        <#--                        <td><input type="button" value="c" onclick="clear()"/> </td>-->
                    </tr>
                    <tr>
                        <td><input type="button" value="(" onclick="dis('(')"></td>
                        <td><input type="button" value=")" onclick="dis(')')"></td>
                        <td><input type="button" value="sin()" onclick="dis('sin(')"></td>
                        <td><input type="button" value="cos()" onclick="dis('cos(')"></td>
                    </tr>
                    <tr>
                        <td><input type="button" value="sqrt()" onclick="dis('sqrt(')"></td>
                        <td><input type="button" value="square()" onclick="dis('square(')"></td>
                        <td><input type="button" value="tan()" onclick="dis('tan(')"></td>
                        <td><input type="button" value="atan()" onclick="dis('atan(')"></td>
                    </tr>
                    <tr>
                        <td><input type="button" value="abs()" onclick="dis('abs(')"></td>
                        <td><input type="button" value="pow" onclick="dis('pow ')"></td>
                        <td><input type="button" value="tan" onclick="dis('tan ')"></td>
                        <td><input type="button" value="atan" onclick="dis('atan ')"></td>
                    </tr>
                    <tr>
                        <td class="digit"><input type="button" value="1" onclick="dis('1')"/></td>
                        <td class="digit"><input type="button" value="2" onclick="dis('2')"/></td>
                        <td class="digit"><input type="button" value="3" onclick="dis('3')"/></td>
                        <td><input type="button" value="/" onclick="dis('/')"/></td>
                    </tr>
                    <tr>
                        <td class="digit"><input type="button" value="4" onclick="dis('4')"/></td>
                        <td class="digit"><input type="button" value="5" onclick="dis('5')"/></td>
                        <td class="digit"><input type="button" value="6" onclick="dis('6')"/></td>
                        <td><input type="button" value="-" onclick="dis('-')"/></td>
                    </tr>
                    <tr>
                        <td class="digit"><input type="button" value="7" onclick="dis('7')"/></td>
                        <td class="digit"><input type="button" value="8" onclick="dis('8')"/></td>
                        <td class="digit"><input type="button" value="9" onclick="dis('9')"/></td>
                        <td><input type="button" value="+" onclick="dis('+')"/></td>
                    </tr>
                    <tr>
                        <td><input type="button" value="." onclick="dis('.')"/></td>
                        <td class="digit"><input type="button" value="0" onclick="dis('0')"/></td>
                        <td><input type="submit" value="="></td>
                        <td><input type="button" value="*" onclick="dis('*')"/></td>
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