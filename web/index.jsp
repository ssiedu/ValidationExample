<html>
    <script>
        function checkAll(){
            var res1 = checkName();
            var res2 = checkAge();
            var res3 = res1 && res2;
            return res3;
        }
        function checkAge(){
            var v1=document.getElementById("t2").value;
            if(isNaN(v1)==true){
                alert("Age Must Be A Number");
                return false;
            }else{
                return true;
            }
        }
        function checkName(){
            var v1=document.getElementById("t1").value;
            var v2=v1.length;
            if(v2==0){
                alert("You Must Enter Name");
                return false;
            }else{
                return true;
            }
        }
    </script>
    
    
    
    <body>
        <h3>Client Side Validation</h3>
        <form action="ProcessData" onsubmit="return checkAll()">
            <pre>
            Name    <input type="text" id="t1" name="t1"/>
            Age     <input type="text" id="t2" name="t2"/>
                    <input type="submit" value="Submit"/>
            </pre>        
        </form>
    </body>
</html>
