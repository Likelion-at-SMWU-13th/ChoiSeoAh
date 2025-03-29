const content = "안녕하세요:)\n멋쟁이 사자처럼 13기\n최서아입니다!"
// 타이핑 하고싶은 텍스트 작성
const text = document.getElementById("dynamic");
let index = 0;
let txt = "";

function typing(){
    if(index < content.length){
    txt += content[index];
    text.innerText = txt;
    index++
    }
}
setInterval(typing,320);