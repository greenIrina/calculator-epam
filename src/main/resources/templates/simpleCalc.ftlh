
<#-- @ftlvariable name="expression" type="String" -->

<#import "/spring.ftl" as spring>
<#import "common.ftlh" as c>

<@c.page>
    <div class="expression form-box">
        <div class="calculator">
            <form method="post" action="">
                <input type="hidden" name="action" value="enter"/>
                <div class="field">
                    <div class="name">
                        <label for="expression">expression</label>
                    </div>
                    <div class="value">
                        <input autofocus id="expression" name="expression" value="${expression!}"/>
                    </div>
                </div>
            </form>
        </div>
    </div>

</@c.page>