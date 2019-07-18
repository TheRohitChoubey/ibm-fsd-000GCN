$(document).ready(() => {
    $('#top-menu').menu({

    });

    $('#tabs').tabs({
        // specify default selected tab
        active: 0
    });;

    const uMap = new Map();

    const eid_data = [];

    $("#enter").click(() => {
        $('#dialog').show();
        $('#dialog').html(`<input type="text" id="empid" value=""><br>
                           <input type="text" id="ename" value=""><br>
                           <input type="submit" class="ui-button ui-widget ui-corner-all" 
                           id="submit-data" name="submit-data" value="Submit">`);

        $('#submit-data').on('click', () => {
            let eid = $('#empid').val();
            let ename = $('#ename').val();
            uMap.set(eid, ename)
            eid_data.push(eid);
            console.log(eid);
            $('#dialog').hide();
            $('#ebody').append(`<tr>
                                <td>${eid}</td>
                                <td>${ename}</td>
                             </tr>   `)
        });
    });

    $("#search").click(() => {
        $('#search-data').autocomplete({
            source: eid_data
        });

        let mData = $('#search-data').val();

        let flag = -1;

        eid_data.forEach((n, i) => {
            if (n == mData) {
                flag = i;
            }
        });

        if (flag != -1) {
            alert("Name = " + uMap.get(eid_data[flag]))
        }
    });


    $('#save-log').click(() => {
        let email = $('#email').val();
        let pass = $('#pass').val();
        console.log(email);
        if (email == "a" && pass == "a") {
            document.location = 'file:///D:/ibm-fsd-000GCN/UI/jQuery/employeedata.html'
        }
    });

    //end of ready function
});