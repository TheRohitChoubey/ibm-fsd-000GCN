class Empdata {

    loadEmployees() {
        let emps = [];
        let rows = '';
        if (localStorage.getItem("emps") != undefined) {
            emps = JSON.parse(localStorage.getItem("emps"));
        }

        console.log(emps);

        // traverse the array 
        emps.forEach((employee) => {
            rows += this.empRow(employee);
        });
        this.empTable(rows);
    }

    empRow(employee) {
        return `<tr>
        <td>${employee.id}</td>
        <td>${employee.name}</td>
        <td>${employee.email}</td>
        <td>${employee.organization}</td>
        <td><a href="#" onclick="findById(${employee.id})">Click here to delete</a></td>
        <td><a href="#" onclick="updateByMail(${employee.id})">Click here to Update</a></td>
    </tr> `
    }
    empTable(rows) {
        let records = `<table>
                    <tr>
                        <th>Id
                        <a href="#" onclick="sortEmployee('ID','Asc')">Asc</a>
                        <a href="#" onclick="sortEmployee('ID','Dsc')">Dsc</a>
                        </th>
                        <th>Name
                        <a href="#" onclick="sortEmployee('NAME','Asc')">Asc</a>
                        <a href="#" onclick="sortEmployee('NAME','Dsc')">Dsc</a>
                        </th>
                        <th>Email
                        <a href="#" onclick="sortEmployee('EMAIL','Asc')">Asc</a>
                        <a href="#" onclick="sortEmployee('EMAIL','Dsc')">Dsc</a>
                        </th>
                        <th>Organization
                        <a href="#" onclick="sortEmployee('ORG','Asc')">Asc</a>
                        <a href="#" onclick="sortEmployee('ORG','Dsc')">Dsc</a>
                        </th>
                        <th>Delete</th>
                        <th>Update</th>
                    </tr>
                    ${rows}    
                </table>`;
        document.getElementById('div-emps').innerHTML = records;
    }

}

const loadEmp = () => {
    const ab = new Empdata();
    ab.loadEmployees();
}

const localStore = () => {
    const emp = {
        id: document.getElementById("eid").value,
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        organization: document.getElementById("org").value,

    };
    let emps = [];
    if (localStorage.getItem("emps") != undefined) {
        emps = JSON.parse(localStorage.getItem("emps"));
    }
    const empFound = emps.find((e) => {
        return emp.email == e.email;
    });

    if (empFound != undefined) {
        alert('Record with similar email adress found!')
    } else {
        emps.push(emp);
        alert('Record added');
    }

    localStorage.setItem("emps", JSON.stringify(emps));
}

const findById = (eid) => {
    const empId = eid;
    let emps = [];
    if (localStorage.getItem("emps") != undefined) {
        emps = JSON.parse(localStorage.getItem("emps"));
    }

    const empFound = emps.find((e) => {
        return empId == e.id;
    });
    if (empFound != undefined) {
        let rows = '';
        emps = emps.filter((emp) => {
            return emp.id != empId;
        });
        localStorage.setItem("emps", JSON.stringify(emps));
        alert('Record deleted');

    } else {
        alert('No Employees Found with the given Criteria');
    }
}

const updateByMail = (eid) => {

    let empId = eid;
    let emps = [];
    if (localStorage.getItem("emps") != undefined) {
        emps = JSON.parse(localStorage.getItem("emps"));
    }
    const empFound = emps.find((e) => {
        return empId == e.id;
    });

    if (empFound != undefined) {
        emps = emps.filter((emp) => {
            return emp.id != empId;
        });
        localStorage.setItem("emps", JSON.stringify(emps));
    }

    let record = `<input type="text" name="id" id="eid" value="${empFound.id}" placeholder="Enter Id" />
        <input type="text" name="name" id="name" value="${empFound.name}" placeholder="Enter name" />
        <input type="text" name="email" id="email" value="${empFound.email}" placeholder="Enter Email" />
        <input type="text" name="Organization" id="org" value="${empFound.organization}" placeholder="Enter Organization" />
        <input type="button" name="add" value="Add" onclick="localStore()" />
        <input type="button" name="loademployee" onclick="loadEmp()" value="Load Employees" />
        <input type="button" name="loademployee" onclick="findById()" value="Delete Employee" />`;

    document.getElementById('details').innerHTML = record;
}

const sortEmployee = (sortBy, sortIn) => {
    const ab = new Empdata();
    let rows = '';
    let emps = [];
    if (localStorage.getItem("emps") != undefined) {
        emps = JSON.parse(localStorage.getItem("emps"));
    }

    let newEmps = emps;
    if (sortBy == 'ID') {
        if (sortIn == 'Dsc') {
            newEmps.sort((emp1, emp2) => {
                if (emp1.id > emp2.id) {
                    return -1;
                } else if (emp1.id < emp2.id) {
                    return 1;
                } else {
                    return 0;
                }
            }).forEach((e) => {
                rows += ab.empRow(e);
            });
            ab.empTable(rows);
        } else if (sortIn == 'Asc') {
            newEmps.sort((emp1, emp2) => {
                if (emp1.id < emp2.id) {
                    return -1;
                } else if (emp1.id > emp2.id) {
                    return 1;
                } else {
                    return 0;
                }
            }).forEach((e) => {
                rows += ab.empRow(e);
            });
            ab.empTable(rows);
        }
    } else if (sortBy == 'NAME') {
        if (sortIn == 'Dsc') {
            newEmps.sort((emp1, emp2) => {
                if (emp1.name < emp2.name) {
                    return 1;
                } else if (emp1.name > emp2.name) {
                    return -1;
                } else {
                    return 0;
                }
            }).forEach((e) => {
                rows += ab.empRow(e);
            });
            ab.empTable(rows);
        } else if (sortIn == 'Asc') {
            newEmps.sort((emp1, emp2) => {
                if (emp1.name > emp2.name) {
                    return 1;
                } else if (emp1.name < emp2.name) {
                    return -1;
                } else {
                    return 0;
                }
            }).forEach((e) => {
                rows += ab.empRow(e);
            });
            ab.empTable(rows);
        }
    } else if (sortBy == 'ORG') {
        if (sortIn == 'Dsc') {
            newEmps.sort((emp1, emp2) => {
                if (emp1.organization > emp2.organization) {
                    return -1;
                } else if (emp1.organization < emp2.organization) {
                    return 1;
                } else {
                    return 0;
                }
            }).forEach((e) => {
                rows += ab.empRow(e);
            });
            ab.empTable(rows);
        } else if (sortIn == 'Asc') {
            newEmps.sort((emp1, emp2) => {
                if (emp1.organization < emp2.organization) {
                    return -1;
                } else if (emp1.organization > emp2.organization) {
                    return 1;
                } else {
                    return 0;
                }
            }).forEach((e) => {
                rows += ab.empRow(e);
            });
            ab.empTable(rows);
        }
    } else if (sortBy == 'EMAIL') {
        if (sortIn == 'Dsc') {
            newEmps.sort((emp1, emp2) => {
                if (emp1.email > emp2.email) {
                    return -1;
                } else if (emp1.email < emp2.email) {
                    return 1;
                } else {
                    return 0;
                }
            }).forEach((e) => {
                rows += ab.empRow(e);
            });
            ab.empTable(rows);
        } else if (sortIn == 'Asc') {
            newEmps.sort((emp1, emp2) => {
                if (emp1.email < emp2.email) {
                    return -1;
                } else if (emp1.email > emp2.email) {
                    return 1;
                } else {
                    return 0;
                }
            }).forEach((e) => {
                rows += ab.empRow(e);
            });
            ab.empTable(rows);
        }
    }
}