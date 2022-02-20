using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace lb6_2_
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btn1_Click(object sender, EventArgs e)
        {
            int index = lstbox.SelectedIndex;
            string str = (string)lstbox.Items[index];
            int len = str.Length;
            int i = 0;
            int count = 0;
            while (i < len)
            {
                if (str[i] >= 'а' && str[i] <= 'я')
                {
                    
                    count++;
                    
                } 
                i++;

            }
            lbl1.Text = "Лише рос. літери = "
                + count.ToString();
        }

        private void lstbox_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}
