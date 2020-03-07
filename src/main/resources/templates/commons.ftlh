<#import "/spring.ftl" as spring/>
<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Cooler Calculator</title>
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/normalize.css'/>">
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/style.css'/>">
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/form.css'/>">
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/datatable.css'/>">
        <script>
            //function that display value
            function dis(val) {
                document.getElementById("expression").value += val;
            }

            function clr() {
                document.getElementById("expresion").value ="";
            }
        </script>
    </head>
    <body>
    <header>
        <nav>
            <ul>
                <li><a href="/">Home</a></li>
                <li><a href="/base">Base Calculator</a></li>
                <li><a href="/engineer">Advanced Calculator</a> </li>
                <li><a href="/help">Help Page</a> </li>
            </ul>
        </nav>
    </header>

    <#nested/>
    </body>
    </html>
</#macro>


<#macro error field>
    <@spring.bind field/>
    <#if spring.status.errorMessage??>
        <div class="error">${spring.status.errorMessage}</div>
    </#if>
</#macro>