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
    if(action!="Action" && document.getElementById('stringType').value !="String type"&& document.getElementById('String').value !="") {
        div.innerHTML = '<td> <input type="hidden" name="action" value="' + action + '"/>' + action + '</td>\
        <td><input type="hidden" name="stringType" value="' + stringType + '"/>' + stringType + '</td>\
        <td><input type="hidden" name="string" value="' + string + '"/>' + string + '</td>\
        <td><input type="hidden" name="textValue" value="' + textValue + '"/>' + textValue + '</td>\
        <td><input type="hidden" name="verificationMessage" value="' + verificationMessage + '"/>' + verificationMessage + '</td>';
        document.getElementById('mytable').appendChild(div);
    }
}

function enableTextValue() {
    var action = document.getElementById("action");
    var text = action.options[action.selectedIndex].text;

    if(text==="Text") {
        document.getElementById('Text_value').disabled=false;
    }else {
        document.getElementById('Text_value').disabled=true;
    }
}