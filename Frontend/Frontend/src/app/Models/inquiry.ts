export class Inquiry {
    inquiryId: number;
    userId: number;
    categoryId: number;
    inquiryName: string;
    numberOfQuestionGroup: number;
    questionGroups: QuestionGroup[] = [];
}

export class QuestionGroup {
    questionGroupId: number;
    questionGroupName: string;
    numberOfQuestion: number;
    questions: Question[] = [];
}

export class Question {
    questionId: number;
    question: string;
    answers: Answer[] = [];
}


export class Answer {
    answerId: number;
    answer: string;
    isCorrect: boolean
}