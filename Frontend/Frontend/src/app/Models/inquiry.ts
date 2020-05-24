export class Inquiry {
    inquiryId: number;
    userId: number;
    categoryId: number;
    inquiryName: string;
    numberOfQuestionGroup: number;
    questionGroups: QuestionGroup[] = new Array<QuestionGroup>()
}

export class QuestionGroup {
    public questionGroupId: number;
    public questionGroupName: string;
    public numberOfQuestion: number;
    public questions: Question[] = new Array<Question>()
}

export class Question {
    questionId: number;
    answers: Answer[] = new Array<Answer>()
}


export class Answer {
    answerId: number;
    answer: string;
    isCorrect: boolean
}