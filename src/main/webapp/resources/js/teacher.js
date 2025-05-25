document.addEventListener("DOMContentLoaded", function () {
    const list = document.getElementById("teacherList");

    function loadTeachers() {
        fetch("/PSK-Lab1-1.0-SNAPSHOT/api/teachers")
            .then(response => response.json())
            .then(data => {
                list.innerHTML = "";
                console.log("Teachers:", data);
                data.forEach(teacher => {
                    const div = document.createElement("div");
                    div.innerHTML = `<strong>ID ${teacher.id}:</strong> ${teacher.name}`;
                    list.appendChild(div);
                });
            })
            .catch(err => console.error("Failed to load teachers:", err));
    }

    loadTeachers();

    // Create teacher
    document.getElementById("createTeacherForm").addEventListener("submit", function (e) {
        e.preventDefault();
        const name = document.getElementById("newTeacherName").value;

        fetch("/PSK-Lab1-1.0-SNAPSHOT/api/teachers", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ name })
        })
            .then(res => {
                if (!res.ok) throw new Error("Failed to create teacher");
                return res.json();
            })
            .then(() => {
                loadTeachers();
                this.reset();
            })
            .catch(err => console.error(err));
    });

    // Update teacher
    document.getElementById("updateTeacherForm").addEventListener("submit", function (e) {
        e.preventDefault();
        const id = parseInt(document.getElementById("updateTeacherId").value);
        const name = document.getElementById("updateTeacherName").value;

        fetch("/PSK-Lab1-1.0-SNAPSHOT/api/teachers", {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ id, name })
        })
            .then(res => {
                if (!res.ok) throw new Error("Failed to update teacher");
                return res.json();
            })
            .then(() => {
                loadTeachers();
                this.reset();
            })
            .catch(err => console.error(err));
    });
});
