package com.example.user.retrofittest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.retrofittest.R;
import com.example.user.retrofittest.model.GitHubRepo;

import java.util.List;

public class GitHubRepoAdapter extends ArrayAdapter<GitHubRepo> {
    private Context context;

    /* 의미있는 변수명 사용
     *  values --> gitHubRepos
     * */
    private List<GitHubRepo> gitHubRepos;

    public GitHubRepoAdapter(Context context, List<GitHubRepo> gitHubRepos) {
        super(context, R.layout.list_item_pagination, gitHubRepos);

        this.context = context;
        this.gitHubRepos = gitHubRepos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item_pagination, parent, false);
        }

        TextView textView = view.findViewById(R.id.list_item_pagination_text);

        GitHubRepo item = gitHubRepos.get(position);
        String name = item.getName();
        textView.setText(name);

        return view;
    }
}

