// let json = `{"grade" : 3, "age" : 25}`;

// try{
//   let user = JSON.parse(json);
//   if (!user.name){
//     throw "사용자 이름이 없습니다.";
//   }
// }catch(err){
//   console.error(err);
// }

const url = 'https://jsonplaceholder.typicode.com/users';
async function init(){
  const response = await fetch(url);
  const users = await response.json();
  console.log(users);
}
init();