/**
 * Created by mayesh on 7/6/17.
 */


function myAction() {
    var action = document.getElementById('action').value;
    var stringType = document.getElementById('stringType').value;
    var string = document.getElementById('String').value;
    var textValue = document.getElementById('Text_value').value;
    var verificationMessage = document.getElementById('Verification_Message').value;


    var div = document.createElement('tr');
    // div.className = 'row';
// div.id =
//     div.innerHTML = ' <td> <input type="hidden" name="name" value=' + action + '/>'+ action + '</td>\
    div.innerHTML = '<td> <input type="hidden" name="action" value="' + action + '"/>' + action + '</td>\
        <td><input type="hidden" name="stringType" value="' + stringType + '"/>' + stringType + '</td>\
        <td><input type="hidden" name="string" value="' + string + '"/>' + string + '</td>\
        <td><input type="hidden" name="textValue" value="' + textValue + '"/>' + textValue + '</td>\
        <td><input type="hidden" name="verificationMessage" value="' + verificationMessage + '"/>' + verificationMessage + '</td>';
    document.getElementById('mytable').appendChild(div);

}