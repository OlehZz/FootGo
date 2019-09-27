function postNewPlayer(data) {
const path = location.toString();
let url = new URL(path);
let searchParams = new URLSearchParams(url.search);

const teamUuid = searchParams.get('teamUuid');

        let firstName = document.getElementById('firstName').value;
        let lastName = document.getElementById('lastName').value;
        let phone = document.getElementById('phone').value;
        let email = document.getElementById('email').value;

    let params = '?firstName=' + firstName
                + '&lastName=' + lastName
                + '&phone=' + phone
                + '&email=' + email;

    let apiUrl = '/team/' + teamUuid + '/player/new' + params;
    fetch(apiUrl, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        body: data
      }
    }).then(function(response){
        if(response.ok) {
            document.getElementById('hideifsuccess').style.display = 'none';
        	document.getElementById('success').style.display = 'block';
        	document.getElementById('success-button').style.display = 'block';
        } else {
            document.getElementById('hideifsuccess').style.display = 'none';
        	document.getElementById('error').style.display = 'block';
        	document.getElementById('success-button').style.display = 'block';
        }
        console.log(response)
        return  response.json();
    }).then(function(data) {
        console.log(data);
    })

}
function returnToTeamsPage() {
    location.href = '/admin/team';
}