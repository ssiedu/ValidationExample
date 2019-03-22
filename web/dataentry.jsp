<%
    String err1=(String)request.getAttribute("errName");
    String err2=(String)request.getAttribute("errAge");
    if(err1==null) err1="";
    if(err2==null) err2="";
%>
<html>
    <body>
        <h3>Server Side Validation</h3>
        <form action="DataProcessing">
            <pre>
            Name    <input type="text" id="t1" name="t1"/> <%=err1%>
            Age     <input type="text" id="t2" name="t2"/> <%=err2%>
                    <input type="submit" value="Submit"/>
            </pre>        
        </form>
    </body>
</html>
