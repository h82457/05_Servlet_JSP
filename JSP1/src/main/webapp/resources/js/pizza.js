console.log("pizza.js 파일이 요청됨");

const miusBtn = document.querySelector("#miusBtn");
const plusBtn = document.querySelector("#plusBtn");
const inputCount = document.querySelector("#inputCount")

let count = 1;

miusBtn.addEventListener("click", () => {
    count--;
    console.log(count);
    inputCount.innerText = "";
    
});

plusBtn.addEventListener("click", () => {
    count++;
});
