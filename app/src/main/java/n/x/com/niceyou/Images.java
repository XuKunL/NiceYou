package n.x.com.niceyou;

import java.util.ArrayList;
import java.util.List;

public class Images {

    public final static String[] imageThumbUrls = new String[] {
            "http://pic1.win4000.com/wallpaper/8/563c5c120dddb.jpg",
            "http://pic1.win4000.com/wallpaper/2/563c5c52bd6d9.jpg",
            "http://old.bz55.com/uploads/allimg/160824/139-160R4142Q8.jpg",
            "http://old.bz55.com/uploads/allimg/160824/139-160R4142Q9.jpg",
            "http://old.bz55.com/uploads/allimg/160824/139-160R4142R2.jpg",
            "http://old.bz55.com/uploads/allimg/170612/140-1F612115535.jpg",
            "http://old.bz55.com/uploads/allimg/170612/140-1F612115536.jpg",
            "http://old.bz55.com/uploads/allimg/170612/140-1F612115538.jpg",
            "http://old.bz55.com/uploads/allimg/170612/140-1F612115539.jpg",
            "http://old.bz55.com/uploads/allimg/170612/140-1F612115540.jpg",
            "http://old.bz55.com/uploads/allimg/170612/140-1F612115543.jpg",
            "http://old.bz55.com/uploads/allimg/170612/140-1F612115548.jpg",
            "http://old.bz55.com/uploads/allimg/170612/140-1F612115549.jpg",
            "http://old.bz55.com/uploads/allimg/170612/140-1F612115551.jpg",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOC0yMy8xNDcxOTY3MTA1eXFTZy5qcGcsMCwwLDEsZjc1MmI1",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOC0yMy8xNDcxOTY3MTA1eWk1Yy5qcGcsMCwwLDEsMzk5YzEx",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOC0yMy8xNDcxOTY3MTA2dFBxay5qcGcsMCwwLDEsY2RhYjJm",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOC0yMy8xNDcxOTY3MTA2Skt2Sy5qcGcsMCwwLDEsY2RhMDgy",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOS0xNC8xNDczODY1ODQ4UmFmVC5qcGcsMCwwLDEsODIwYjBk",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOS0xNC8xNDczODY1ODUxeVVnbS5qcGcsMCwwLDEsZDcyMjEw",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOS0xNC8xNDczODY1ODUzdXBDay5qcGcsMCwwLDEsYzI2NTgy",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOS0xNC8xNDczODY1ODYxd0dGTS5qcGcsMCwwLDEsNzc4M2Fh",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOS0wOS8xNDczNDMzODg4ZFNLSi5qcGcsMCwwLDEsODE2ZThl",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOC0yNy8xNDcyMjY3NDEyczhWZi5qcGVnLDAsMCwxLGZmNjcyMQ!!",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOC0yNy8xNDcyMjY3NDEyMlRFTS5qcGVnLDAsMCwxLDYwMWJlMw!!",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOC0yNy8xNDcyMjY3NDEzOFRTSy5qcGVnLDAsMCwxLDI1NzZmYQ!!",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOC0yNy8xNDcyMjY3NDEzNnJXSy5qcGVnLDAsMCwxLGQxMmZjMg!!",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOC0yNy8xNDcyMjY3NDEzRnR5ci5qcGVnLDAsMCwxLDNlNTY3OA!!",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOC0yMy8xNDcxOTY2NTEwRlRhRS5qcGcsMCwwLDEsODk3MDc1",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOC0yMy8xNDcxOTY2Mzc3ZW41OS5qcGcsMCwwLDEsN2ExOGY3",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOC0yMy8xNDcxOTY2Mzc3dTdtVy5qcGcsMCwwLDEsMWI0ODA3",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOC0yMy8xNDcxOTY1NjczOWlyUy5qcGcsMCwwLDEsNzFmNTM3",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOC0yMy8xNDcxOTY1NjcyVnRqTS5qcGcsMCwwLDEsNTk0ZTJi",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOC0yMy8xNDcxOTY1NDgzTHJjYi5qcGcsMCwwLDEsNjVlNzcz",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOC0yNC8xNDcxOTY4Mjg0S1dudC5qcGcsMCwwLDEsN2M0Nzdj",
            "http://www.isfoot.cc/attach.php?r=MjAxNi0wOC0yNC8xNDcxOTY4ODM3VUp5aS5qcGcsMCwwLDEsNDg1NjFm",
    };
}