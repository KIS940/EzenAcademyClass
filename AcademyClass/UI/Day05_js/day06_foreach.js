const students = ["Park", "Kim", "Lee", "Kang"];

// students.forEach(function(student){
//   document.write(`${student}.`);
// })


students.forEach(student => document.write(`${student}<br>`));

const gitBook ={
  title : "깃&깃허브 입문",
  pubDate : "2019-12-06",
  pages : 272,
  finished : true
}

for(key in gitBook){
  document.write(`${key} : ${gitBook[key]}<br>`);
}

for(let student of students){
  document.write(`${student}<br>`);
}