const selectedTypeButton = document.querySelector(".selected-type-button");
const typeSelectedBoxList = document.querySelector(".type-selected-box-list");

const typeSelectedBoxListLis = document.querySelector("li");
const todoContentList = document.querySelector(".todo-content-list");
const incompleteCountNumber = document.querySelector(".incomplete-count-number");
const sectionBody = document.querySelector(".section-body");

let page = 1;
let totalPage = 0;

selectedTypeButton.onclick = () => {
    typeSelectedBoxList.classList.toggle("visible");
}

/*selectedTypeButton.onblur = () => {
    typeSelectedBoxList.classList.toggle("visible");
}*/

let listType = "all";
load();

sectionBody.onscroll = () => {
	console.log("sectionBody:" + sectionBody.offsetHeight);
	console.log("scrollTop:" + sectionBody.scrollTop);
	console.log("todoContentList:" + todoContentList.clientHeight);
}

	let checkNum = todoContentList.clientHeight = sectionBody.offsetHeight - sectionBody.scrollTop;

	if (checkNum < 1 && checkNum > -1 && page < totalPage) {
		
		page++;
		load();
	}

for(let i = 0; i < typeSelectedBoxListLis.length; i++) {
	typeSelectedBoxListLis[i].onclick = () => {
		
		page = 1;// 클릭시 page 초기화
		
		for(let i = 0; i < typeSelectedBoxListLis.length; i++) {
			typeSelectedBoxListLis[i].classList.remove("type-selected");
		}
		
		typeSelectedBoxListLis[i].classList.add("type-selected");
		const selectedType = document.querySelector(".selected-type");
		selectedType.textContent = typeSelectedBoxListLis[i].textContent;
		
		listType = typeSelectedBoxListLis[i].textContent.toLowerCase();
		todoContentList.innerHTML = ``;
		load();
		 typeSelectedBoxList.classList.toggle("visible");
	};
};

function load() {
    $.ajax ({
        type: "GET",
        url: `/api/v1/todolist/list/${listType}`,
        data: {
            "page": page,
            contentCount: 20
        },
        dataType:"json",
        success: (response) => {
			console.log(response);
            getList(response.data);
        },
        error:
            errorMessage
    });
}

function errorMessage(request,status,error) {
    alert("요청실패");
    console.log(request.status);
    console.log(status);
    console.log(request.responseText);
    console.log(error);
}

function getList(data) {
   
	incompleteCountNumber.textContent = data[0].incompleteCount;
    for(let content of data) {
        todoContentList.innerHTML += `
                            <li class="todo-content">
                            <input type="checkbox" id="complete-check-${content.todoCode}" 
                            class="complete-check" ${content.todoComplete ? "checked" : ""}>
                            <label for="Complete-check-${content.todoCode}"></label>
                            <div class="todo-content-text">${content.todo}</div>
                            <input type="text" class="todo-content-input visible" value="${content.todo}">
                            <input type="checkbox" id="importance-check-${content.todoCode}" 
                            class="importance-check" ${content.importance ? "checked" : ""}>
                            <label for="importance-check-${content.todoCode}"></label>
                            <div class="trash-button"><i class="fa-solid fa-trash-can"></i></div>
                            </li>
        `;
        
        
    }
	addEvent();
}

function setTotalCount(totalCount) {
	totalCount % 20 == 0 ? totalCount / 20 : Math.floor(totalCount / 20) + 1;
}

function addEvent() {
	const todoContents = document.querySelector(".todo-content");
	
	for(let i = 0; i < todoContents.length; i++) {
		
		let todoCode = todoContents[i].querySelector(".complete-check").getAttribute("id");
		console.log("id:" + todoCode);
		
		let index = todoCode.lastIndexOf("-");
		todoCode = todoCode.substring(index + 1);
			
		todoContents[i].querySelector(".complete-check").onchange = () => {
			/*console.log("complete-check" + todoCode);*/
			updateStatus("complete", todoCode);
		}
		todoContents[i].querySelector(".importance-check").onchange = () => {
			console.log("importance-check" + todoCode);
		}
		todoContents[i].querySelector(".trash-button").onclick = () => {
			console.log("trash-button" + todoCode);
		}
	}
	
	
}

function updateStatus(type, todoCode) {
	console.log(type,todoCode);
	result = false;
	
	$.ajax({
		type: "put",
		url: `api/v1/todolist/${type}/todo/${todocode}`,
		async: false,
		dataType: "json",
		success: (response) => {
			result = response.data;
		},
		error:errorMessage
	})
	return result;
}

function updateCheckStatus(type, todoContent, todoCode) {
	
}

function deleteTodo(todoContent, todoCode) {
	
}
