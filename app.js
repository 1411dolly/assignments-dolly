function simpl()
{
    var p,r,t;
    p=parseFloat(prompt("Please Enter Principle Amount"));
    r=parseFloat(prompt("Please Enter Rate Amount"));
    t=parseFloat(prompt("Please Enter Time(year)"));
    var si=(p*r*t)/100;
    document.write("Simple Interest (calculated anually) is: "+si);
}

function palindrome()
{
    var s,str;
    s=prompt("Enter String");
    document.write(s==s.split('').reverse().join(''));
    // document.write(str);
}

function area() {
    r=prompt("Enter Radius");
    var area=Math.PI*Math.pow(r,2);
    document.write("Area of Circle is: "+area);
}

function copy_loop() {
    function copy(mainObj) {
        var objCopy = {}; // objCopy will store a copy of the mainObj
        var key;
        for (key in mainObj) {
            objCopy[key] = mainObj[key]; // copies each property to the objCopy object
        }
        return objCopy;
    }
    var mainObj = {
        name:'dolly1',age:23
    }
    console.log(copy(mainObj));
    // document.write(copy(mainObj));
    alert("see output in console");
}

function employee() {
    var list = [
        { name:'dolly1',age:23,salary:7000,dob:'14/12/1995'},
        { name:'dolly2',age:22,salary:5000,dob:'14/12/1995'},
        { name:'dolly3',age:21,salary:10000,dob:'14/12/1995'},
        { name:'dolly4',age:20,salary:3000,dob:'14/12/1995'},
        { name:'dolly5',age:25,salary:1000,dob:'14/12/1995'}
    ];
    // console.log(list);
    var salg={};
    var key;
    for(key in list)
    {if(list[key].salary > 5000)
        salg[key]=list[key];
    }
    // document.write(salg.name);
    alert("see output in console");
    console.log(salg);

}
function employee_age() {
    var a = [
        { name:'dolly1',age:20,salary:7000,dob:'14/12/1995'},
        { name:'dolly2',age:22,salary:5000,dob:'14/12/1995'},
        { name:'dolly3',age:21,salary:10000,dob:'14/12/1995'},
        { name:'dolly4',age:20,salary:3000,dob:'14/12/1995'},
        { name:'dolly5',age:22,salary:1000,dob:'14/12/1995'}
    ];

    var list={};
    for(var i=0;i<=4;i++)
    {
        // console.log(list[a[i].age]);
       if(!list[a[i].age])
           list[a[i].age]=[a[i]];
       else
           list[a[i].age].push(a[i]);
    }
    console.log(list);

 }

function salary() {
    var list = [
        { name:'dolly1',age
                :23,salary:7000,dob:'14/12/1995'},
        { name:'dolly2',age:22,salary:5000,dob:'14/12/1995'},
        { name:'dolly3',age:21,salary:10000,dob:'14/12/1995'},
        { name:'dolly4',age:20,salary:3000,dob:'14/12/1995'},
        { name:'dolly5',age:25,salary:1000,dob:'14/12/1995'}
    ];
    var sal={};
    var key;
    for(key in list)
    {if(list[key].salary<=1000&&list[key].age > 20)
        sal[key]=list[key];
        list[key].salary=list[key].salary*5;
    }
    alert("see output in console");
    console.log(sal);

}
