class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] t = pos.split(":");
        int m = Integer.parseInt(t[0]);
        int s = Integer.parseInt(t[1]);
        String[] video = video_len.split(":");
        int videoM = Integer.parseInt(video[0]);
        int videoS = Integer.parseInt(video[1]);
        String[] opStart = op_start.split(":");
        int startM = Integer.parseInt(opStart[0]);
        int startS = Integer.parseInt(opStart[1]);
        String[] opEnd = op_end.split(":");
        int endM = Integer.parseInt(opEnd[0]);
        int endS = Integer.parseInt(opEnd[1]);

        int start = startM * 60 + startS;
        int end = endM * 60 + endS;
        int now = m * 60 + s;
        if(start <= now && end >= now) {
            m = endM;
            s = endS;
        }
        for(int i = 0; i < commands.length; i++) {
            if(commands[i].equals("next")) {
                s += 10;
                if(s >= 60) {
                    m += 1;
                    s -= 60;
                }
                if(m >= videoM && s >= videoS) {
                    m = videoM;
                    s = videoS;
                }
            }
            if(commands[i].equals("prev")) {
                s -= 10;
                if(s < 0) {
                    m -= 1;
                    s = 60 + s;
                }
                if(m < 0) {
                    m = 0;
                    s = 0;
                }
            }
            now = m * 60 + s;
            if(start <= now && end >= now) {
                m = endM;
                s = endS;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(m < 10) {
            sb.append("0");
        }
        sb.append(m + ":");
        if(s < 10) {
            sb.append("0");
        }
        sb.append(s);
        return sb.toString();
    }
    
}
