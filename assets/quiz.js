// Shared quiz widget. Markup contract:
// <div class="quiz">
//   <div class="q">Question text?</div>
//   <div class="options">
//     <button class="opt" data-correct="false" data-feedback="Chưa đúng — gợi ý ...">Answer A</button>
//     <button class="opt" data-correct="true"  data-feedback="Đúng — vì ...">Answer B</button>
//   </div>
//   <div class="feedback"></div>
// </div>
// Answers should all be roughly the same length/word count — see SKILL.md rule
// against giving away the answer through formatting.
(function () {
  function initQuiz(quiz) {
    var buttons = quiz.querySelectorAll("button.opt");
    var feedback = quiz.querySelector(".feedback");
    var solved = false;

    buttons.forEach(function (btn) {
      btn.addEventListener("click", function () {
        if (solved) return;
        var isCorrect = btn.getAttribute("data-correct") === "true";
        btn.classList.add(isCorrect ? "correct" : "wrong");
        if (feedback) feedback.textContent = btn.getAttribute("data-feedback") || "";
        if (isCorrect) {
          solved = true;
          buttons.forEach(function (b) { b.disabled = true; });
        } else {
          setTimeout(function () { btn.classList.remove("wrong"); }, 900);
        }
      });
    });
  }

  document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll(".quiz").forEach(initQuiz);
  });
})();
