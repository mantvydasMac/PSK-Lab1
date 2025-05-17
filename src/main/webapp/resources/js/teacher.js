document.addEventListener("DOMContentLoaded", function () {
    fetch("/PSK-Lab1-1.0-SNAPSHOT/api/teachers")
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error " + response.status);
            }
            return response.text(); // temporarily use text
        })
        .then(text => {
            console.log("Raw response:", text); // See what's returned
            const data = JSON.parse(text); // now parse manually
            const list = document.getElementById("teacherList");
            data.forEach(teacher => {
                const div = document.createElement("div");
                div.innerHTML = `<strong>${teacher.name}</strong>`;
                list.appendChild(div);
            });
        })
        .catch(err => console.error("Failed to load teachers:", err));
});