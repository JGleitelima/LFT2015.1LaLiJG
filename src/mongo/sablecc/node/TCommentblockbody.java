/* This file was generated by SableCC (http://www.sablecc.org/). */

package mongo.sablecc.node;

import mongo.sablecc.analysis.*;

@SuppressWarnings("nls")
public final class TCommentblockbody extends Token
{
    public TCommentblockbody(String text)
    {
        setText(text);
    }

    public TCommentblockbody(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TCommentblockbody(getText(), getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTCommentblockbody(this);
    }
}
