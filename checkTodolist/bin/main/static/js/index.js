const selectedTypeButton = document.querySelector(".selected-type-button");
const typeSelectedBoxList = document.querySelector(".type-selected-box-list");

const typeSelectedBoxListLis = document.querySelector("li");
const todoContentList = document.querySelector(".todo-content-list");


selectedTypeButton.onclick = () => {
    typeSelectedBoxList.classList.toggle("visible");
}

/*selectedTypeButton.onblur = () => {
    typeSelectedBoxList.classList.toggle("visible");
}*/

let listType = "all";
load();

for(let i = 0; i < typeSelectedBoxListLis.length; i++) {
	typeSelectedBoxListLis[i].onclick = () => {
		
		listType = typeSelectedBoxListLis[i].textContent.toLowerCase();
	};
};

function load() {
    $.ajax ({
        type: "GET",
        url: `/api/v1/todolist/list/${listType}`,
        data: {
            page: 1,
            contentCount: 20
        },
        dataType:"json",
        success: (response) => {
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
    console.log(data[0].todo);
    console.log(data[0].importance);
    console.log(data[0].todoComplete);

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

}


