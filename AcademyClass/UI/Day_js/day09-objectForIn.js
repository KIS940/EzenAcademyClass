let bag = {
  type : "backpack",
  color : "blue",
  size : 15
}
for(key in bag){
  console.log(`${key}`);
}
for(key in bag){
  console.log(`${key} : ${bag[key]}`);
}

let book1 = {
  title : "웹 표준의 정석",
  pages : 648,
  buy : function(){
    console.log("이 책을 구입했습니다.");
  }
}
let keys = Object.keys(book1);
console.log(keys);
let values = Object.values(book1);
console.log(values);
let entries = Object.entries(book1);
console.log(entries);