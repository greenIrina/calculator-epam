<#-- @ftlvariable name="expression" type="java.lang.String" -->

<#import "/spring.ftl" as spring/>
<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Cooler Calculator</title>
    </head>
    <body>
    <div class="enter form-box">
        <div class="header">Enter</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="enter"/>
                <div class="field">
                    <div class="name">
                        <label for="login">Login</label>
                    </div>
                    <div class="value">
                        <input autofocus id="login" name="login" value="${expression!}"/>
                    </div>
                </div>
                <div class="button-field">
                    <input type="submit" value="Enter">
                </div>
            </form>
        </div>
    </div>

    </body>

    </html>
</#macro>


