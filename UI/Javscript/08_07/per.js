function clickMe() {

    let m = document.getElementById('maths');
    let e = document.getElementById('english');
    let cs = document.getElementById('cse');


    let maths = parseInt(m.value);
    let english = parseInt(e.value);
    let cse = parseInt(cs.value);
    let rows;

    rows += `<tr><td>1</td><td>English</td><td>`;

    if (english < 60) {
        rows += "Failed</td>";
    } else {
        if (english >= 90)
            rows += 'A+</td>';
        if (english > 80 && english < 90)
            rows += 'A</td>';
        else if (english < 80)
            rows += 'B+</td>';
    }

    rows += `<tr><td>2</td><td>Maths</td><td>`;

    if (maths < 60) {
        rows += "Failed</td>";
    } else {
        if (maths >= 90)
            rows += 'A+</td>';
        if (maths > 80 && maths < 90)
            rows += 'A</td>';
        else if (maths < 80)
            rows += 'B+</td>';
    }

    rows += `<tr><td>3</td><td>Computer Science</td><td>`;

    if (cse < 60) {
        rows += "Failed</td>";
    } else {
        if (cse >= 90)
            rows += 'A+</td>';
        if (cse > 80 && cse < 90)
            rows += 'A</td>';
        else if (cse < 80)
            rows += 'B+</td>';
    }

    let _table = `<table>
    <tr><th>S.No</th><th>Subject</th><th>Grades</th></tr>
    ${rows}
    </table>`;
    document.getElementById('msgs').innerHTML = _table;
}