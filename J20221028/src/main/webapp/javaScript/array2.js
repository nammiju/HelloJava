// array2.js
fetch('./MemberListServlet')
    .then(result => result.json())
    .then(listShow)
    .catch(error => console.error(error));

function listShow(data = []) { // 함수의 변수명은 맘대로 정하는 거심.
    //responsibility가 admin 사람만 출력
    // data.filter(row => row.responsibility == 'admin')
    // .forEach(row => console.log(row));  // 방법1
    data.forEach(member => {
        if (member.responsibility == 'admin')
            console.log(member); // 방법2
    })
    // console.log(data);

    // 권한 user인 사람들만 userGroup
    // data.filter(row => row.responsibility == 'user')
    // .map(row => {
    //     let userGroup = {
    //         user_id: row.id,
    //         user_name: row.name,
    //         user_email: row.email,
    //         user_responsibility: row.responsibility
    //     }
    //     return userGroup;
    // }).forEach(userGroup => console.log(userGroup));
    let userGroup = [];
    // foEach를 사용하면..
    data.forEach(member => {
        if (member.responsibility == 'user')
            userGroup.push(member);
    }) 
    console.log(userGroup)
    // filter를 사용하면..
    userGroup = data.filter(member => member.responsibility == 'user');
}