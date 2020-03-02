<#-- @ftlvariable name="message" type="java.lang.String" -->
<#-- @ftlvariable name="expression" type="java.lang.String" -->

<#import "/spring.ftl" as spring>
<#import "commons.ftlh" as c>
<@c.page>
<div class="enter form-box">
    <div class="header">Enter expression</div>
    <div class="body">
        <form method="post" action="">
            <input type="hidden" name="action" value="calc"/>
            <div class="field">
                <div class="name">
                    Expression
                </div>
                <div class="value">
                    <label for="expression"><input autofocus id="expression" name="expression"
                                                   value="${expression!}"/></label>
                </div>
            </div>
            <div class="button-field">
                <input type="submit" value="Enter">
            </div>
            <div class="message">
                <#if message??>
                    ${message}
                </#if>
            </div>
        </form>
    </div>
</div>
</@c.page>