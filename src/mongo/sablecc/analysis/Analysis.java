/* This file was generated by SableCC (http://www.sablecc.org/). */

package mongo.sablecc.analysis;

import mongo.sablecc.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseTComma(TComma node);
    void caseTColon(TColon node);
    void caseTScolon(TScolon node);
    void caseTLpar(TLpar node);
    void caseTRpar(TRpar node);
    void caseTLsbrack(TLsbrack node);
    void caseTRsbrack(TRsbrack node);
    void caseTLcbrack(TLcbrack node);
    void caseTRcbrack(TRcbrack node);
    void caseTAtrib(TAtrib node);
    void caseTPlus(TPlus node);
    void caseTMinus(TMinus node);
    void caseTTimes(TTimes node);
    void caseTDiv(TDiv node);
    void caseTEqual(TEqual node);
    void caseTDiff(TDiff node);
    void caseTLess(TLess node);
    void caseTLequal(TLequal node);
    void caseTGreater(TGreater node);
    void caseTGequal(TGequal node);
    void caseTAnd(TAnd node);
    void caseTOr(TOr node);
    void caseTNot(TNot node);
    void caseTIf(TIf node);
    void caseTElse(TElse node);
    void caseTWhile(TWhile node);
    void caseTFor(TFor node);
    void caseTForeach(TForeach node);
    void caseTFloat(TFloat node);
    void caseTInt(TInt node);
    void caseTChar(TChar node);
    void caseTVoid(TVoid node);
    void caseTReturn(TReturn node);
    void caseTNew(TNew node);
    void caseTId(TId node);
    void caseTNumint(TNumint node);
    void caseTNumfloat(TNumfloat node);
    void caseTString(TString node);
    void caseTLChar(TLChar node);
    void caseTEspacobranco(TEspacobranco node);
    void caseTCommentline(TCommentline node);
    void caseTCommentblock(TCommentblock node);
    void caseTCommentblockend(TCommentblockend node);
    void caseTCommentblockbody(TCommentblockbody node);
    void caseTCommentblockerror(TCommentblockerror node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
