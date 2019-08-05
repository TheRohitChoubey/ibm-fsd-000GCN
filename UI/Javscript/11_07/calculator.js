class Calc {
    operation(val) {
        let var1 = JSON.parse(localStorage.getItem("var1"));
        let op1 = JSON.parse(localStorage.getItem("op1"));
        if (op1 == '+') {
            var1 = parseInt(var1) + parseInt(val);
        } else if (op1 == '-') {
            var1 = var1 - val;
        } else if (op1 == '*') {
            var1 = var1 * val;
        } else if (op1 == '/') {
            var1 = var1 / val;
        }
        localStorage.setItem("var1", JSON.stringify(var1));
        localStorage.setItem("var2", JSON.stringify(val));
    }
    uNum(val) {

        let var1 = JSON.parse(localStorage.getItem("var1"));
        if (localStorage.getItem("var1") == undefined && (val != '=')) {
            localStorage.setItem("var1", JSON.stringify(val));
        } else if ((val == '+' || val == '-' || val == '/' || val == '*')) {
            localStorage.setItem("op1", JSON.stringify(val));
            if (localStorage.getItem("var2") != undefined) {
                let var1 = JSON.parse(localStorage.getItem("var1"));
                document.getElementById("eval").value = var1;
                console.log(val);
            }
        } else if (localStorage.getItem("var1") != undefined && (val != '=')) {
            this.operation(val);
            localStorage.removeItem("equal");
        } else if (val == '=') {

            let var1 = JSON.parse(localStorage.getItem("var1"));

            if (localStorage.getItem("equal") == undefined) {
                document.getElementById("eval").value = var1;
                localStorage.setItem("equal", JSON.stringify(val));
                console.log(var1);
            } else {
                let var2 = JSON.parse(localStorage.getItem("var2"));
                this.operation(var2);
                let var1 = JSON.parse(localStorage.getItem("var1"));
                document.getElementById("eval").value = var1;
            }

        }

    }
}

function operate(val) {
    const ab = new Calc();
    if (val == "Clear") {
        document.getElementById("eval").value = "";
        localStorage.removeItem("var1");
        localStorage.removeItem("op1");
        localStorage.removeItem("var2");
        localStorage.removeItem("equal");
    } else {
        document.getElementById("eval").value = val;
        ab.uNum(val);
    }
}