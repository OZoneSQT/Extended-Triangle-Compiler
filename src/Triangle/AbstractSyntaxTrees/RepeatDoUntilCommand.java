package Triangle.AbstractSyntaxTrees;

/*

ITCR- IC-5701 - Proyecto 1

Modificaciones realizadas

Autores:
Eric Alpizar y Jacob Picado

Descripción:

Nueva estructura de datos para el AST de RepeatDoUntilCommand

Ultima fecha de modificación:

28/09/2021

 */

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RepeatDoUntilCommand extends Command {
    public RepeatDoUntilCommand(Command cAST_do, Expression eAST_do, SourcePosition thePosition) {
        super(thePosition);
        C = cAST_do;
        E = eAST_do;
    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitRepeatDoUntilCommand(this, o); }

    public Command C;
    public Expression E;
}
