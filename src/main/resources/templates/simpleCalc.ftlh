<#-- @ftlvariable name="message" type="java.lang.String" -->
<#-- @ftlvariable name="expression" type="java.lang.String" -->

<#import "/spring.ftl" as spring>
<#import "commons.ftlh" as c>
<@c.page>

    <div class="calculator form-box">
        <div class="header">BASE CALCULATOR</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="calc"/>
                <table>
                    <tr>
                        <td colspan="4"><input autofocus type="text" id="expression" name="expression"
                                               value="${expression!}"/></td>
                    </tr>
                    <tr>
                        <td><input type="button" value="(" onclick="dis('(')"></td>
                        <td><input type="button" value=")" onclick="dis(')')"></td>
                        <td><input type="button" value="/" onclick="dis('/')"/></td>
                        <td><input type="button" value="*" onclick="dis('*')"/></td>
                    </tr>
                    <tr>
                        <td class="digit"><input type="button" style="color: green; background: #E1E1E1" value="1"
                                                 onclick="dis('1')"/></td>
                        <td class="digit"><input type="button" style="color: green; background: #E1E1E1" value="2"
                                                 onclick="dis('2')"/></td>
                        <td class="digit"><input type="button" style="color: green; background: #E1E1E1" value="3"
                                                 onclick="dis('3')"/></td>
                        <td><input type="button" value="+" onclick="dis('+')"/></td>
                    </tr>
                    <tr>
                        <td class="digit"><input type="button" style="color: green; background: #E1E1E1" value="4"
                                                 onclick="dis('4')"/></td>
                        <td class="digit"><input type="button" style="color: green; background: #E1E1E1" value="5"
                                                 onclick="dis('5')"/></td>
                        <td class="digit"><input type="button" style="color: green; background: #E1E1E1" value="6"
                                                 onclick="dis('6')"/></td>
                        <td><input type="button" value="-" onclick="dis('-')"/></td>
                    </tr>
                    <tr>
                        <td class="digit"><input type="button" style="color: green; background: #E1E1E1" value="7"
                                                 onclick="dis('7')"/></td>
                        <td class="digit"><input type="button" style="color: green; background: #E1E1E1" value="8"
                                                 onclick="dis('8')"/></td>
                        <td class="digit"><input type="button" style="color: green; background: #E1E1E1" value="9"
                                                 onclick="dis('9')"/></td>
                        <td rowspan="2"><input type="submit" style="height: 6rem" value="="></td>
                    </tr>
                    <tr>
                        <td><input type="button" value="." onclick="dis('.')"/></td>
                        <td class="digit"><input type="button" style="color: green; background: #E1E1E1" value="0"
                                                 onclick="dis('0')"/></td>
                        <td></td>
                        <td></td>
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