export class Inquiry {
    public inquiryId: number;
    public userId: number;
    public categoryId: number;
    public inquiryName: string;
    public numberOfQuestionGroup: number;
    public questionGroups: QuestionGroup[] = [];
}

export class QuestionGroup {
    public questionGroupId: number;
    public questionGroupName: string;
    public numberOfQuestion: number;
    public questions: Question[] = [];
}

export class Question {
    public questionId: number;
    public question: string;
    public answers: Answer[] = [];
}


export class Answer {
    public answerId: number;
    public answer: string;
    public isCorrect: boolean
}