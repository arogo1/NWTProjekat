import { NumberSymbol } from '@angular/common';

export class Quiz {
    quizId: number;
    inquiryId: number;
    result: number;
    numberOfAnswers: number;
}

export class DoneQuiz{
    quizId: number;
    userId: number;
}